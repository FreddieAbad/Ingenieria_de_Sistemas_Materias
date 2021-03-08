import firebase from 'firebase/app';
import 'firebase/firestore';
const firebaseConfig = {
    apiKey: "AIzaSyA8CuYIJxvaPOf1VtifDFbprMFCHnhP1qY",
    authDomain: "practica1bigdata.firebaseapp.com",
    databaseURL: "https://practica1bigdata.firebaseio.com",
    projectId: "practica1bigdata",
    storageBucket: "practica1bigdata.appspot.com",
    messagingSenderId: "915708650420",
    appId: "1:915708650420:web:63ae1286105013c9d088e1"
};
// Initialize Firebase
firebase.initializeApp(firebaseConfig);
console.log("Firebase OK");
export default firebase.firestore();


