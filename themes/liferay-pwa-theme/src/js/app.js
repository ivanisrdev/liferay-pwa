/**
 * Check if exist service worker in navigator and register file.
 */
if ('serviceWorker' in navigator) {
    navigator.serviceWorker.register('/sw.js')
        .then(function() {
            console.log('Service worker registered.');
        })
        .catch(function() {
            console.warn('Service worker failed.')
        });
}

// Service worker register
// if ('serviceWorker' in navigator) {
//     window.addEventListener('load', function() {
//         navigator.serviceWorker.register('${javascript_folder}/service-worker.js', { scope: '/' }).then(function(registration) {
//             console.log('ServiceWorker registration successful with scope: ', registration.scope);
//         }, function(err) {
//             console.log('ServiceWorker registration failed: ', err);
//         });
//     });
// }