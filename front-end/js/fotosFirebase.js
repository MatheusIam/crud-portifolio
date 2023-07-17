// Import the functions you need from the SDKs you need
import { initializeApp } from "https://www.gstatic.com/firebasejs/10.0.0/firebase-app.js";
// getStorage, deleteObject, ref, getDownloadURL
import { getStorage, deleteObject, ref, getDownloadURL} from "https://www.gstatic.com/firebasejs/10.0.0/firebase-storage.js";
// TODO: Add SDKs for Firebase products that you want to use
// https://firebase.google.com/docs/web/setup#available-libraries

// Your web app's Firebase configuration
const firebaseConfig = {
    apiKey: "AIzaSyB57K059eaIHCgVaIa306dHG9iytaIlt0s",
    authDomain: "crud-portifolio.firebaseapp.com",
    projectId: "crud-portifolio",
    storageBucket: "crud-portifolio.appspot.com",
    messagingSenderId: "989004190421",
    appId: "1:989004190421:web:dcea60bbf784bb95cb085c"
};

// Initialize Firebase
const app = initializeApp(firebaseConfig);

// Recupera a pasta raiz
const raiz = getStorage();
// Especifica que elemento eu quero
const gato = 'gato.jpg';
// Diz onde está a pasta raiz de fotos
const raizFotos = ref(raiz, `foto/${gato}`);

// Recupere um objeto dentro da pasta referenciada
getDownloadURL(raizFotos)
    .then((url) => {
        const gatoNoHtml = document.getElementById('gato');
        gatoNoHtml.setAttribute('src', url);
    });