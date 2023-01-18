// self.addEventListener("install", e => {
//     console.log("Instalando");
// })
// self.addEventListener("fetch", function(event) {
//     console.log("Fetch");
// })
self.addEventListener('fetch', function(e) {
    e.respondWith(
        caches.match(e.request).then(function(response) {
            return response || fetch(e.request);
        })
    );
});