//importScripts('https://cdnjs.cloudflare.com/ajax/libs/cache.adderall/1.0.0/cache.adderall.js');
const CACHE_NAME = 'static-v1.1';
const STATIC_FILES = [
  '/'
];
/**
 * Install PWA.
 */
self.addEventListener('install', function(event) {
    event.waitUntil(
        caches.open(CACHE_NAME).then(function(cache) {
            console.log('cache ' + JSON.stringify(cache));
            return cache.addAll(STATIC_FILES);
        })
    )
});

/**
 * Active service worker.
 */
self.addEventListener('active', function activator(event) {
    event.waitUntil(
        caches.keys().then(function(keys) {
            return Promise.all(keys
                .filter(function(key) {
                    return key.indexOf(CACHE_NAME) !== 0;
                })
                .map(function(key) {
                    return caches.delete(key);
                })
            );
        })
    );
});

/**
 * Intercepet request cache.
 */
self.addEventListener('fetch', function(event) {
    event.respondWith(
        caches.match(event.request).then(function (cachedResponse) {
            return cachedResponse || fetch(event.request);
        })
    );
});

/**
 * Push notification.
 */
self.addEventListener('push',function(event){
    let serverData = event.data.json();
    if(serverData){
        let notifiBody = serverData.body;
        let imageIcon = serverData.imageUrl;
        let redirectUrl = serverData.redirectUrl;
        self.registration.showNotification(serverData.title,{
            body : notifiBody,
            icon : imageIcon,
            data: {
                dateOfArrival: Date.now(),
                primaryKey: 1,
                redirectUrl : redirectUrl
            },
            timeout : 1000
        });
    }else{
        console.log("There is no data to be displayed.");
    }
});

/**
 * Notification popup.
 */
self.addEventListener('notificationclick', function(event) {
    let url = event.notification.data.redirectUrl;
    event.waitUntil(
        clients.matchAll({type: 'window'}).then( windowClients => {
            for (const element of windowClients) {
                let client = element
                if (client.url === url && 'focus' in client) {
                    return client.focus();
                }
            }
            if (clients.openWindow) {
                return clients.openWindow(url);
            }
        })
    );
}); 
