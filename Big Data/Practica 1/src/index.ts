import db from './firebase/config';

//CREATE TABLE USUARIO
const usuario = {
    nombre: "Freddy Abad",
    estadoMatricula: true,
    materia: "Optativa 9 - Big Data",
    estadoAprobacion: false
}

//INSERT INTO USUARIO
// db
//     .collection('usuarios')
//     .add(usuario)
//     .then(referencia => {
//         console.log(referencia);
//     }).catch(e => {
//         console.log('error ', e);
//     });

// UPDATE
// db
//     .collection('usuarios')
//     .doc('s2G62d2C6jMKtfdo3mnI')
//     .update({
//         estadoAprobacion: true
//     })

//SET
// db
//     .collection('usuarios')
//     .doc('s2G62d2C6jMKtfdo3mnI')
//     .set({
//         nombre: "Freddy Abad",
//         estadoMatricula: true,
//         materia: "Optativa 9 - Big Data",
//         estadoAprobacion: false
//     })

//DELETE
// db
//     .collection('usuarios')
//     .doc('yMoHDu1lCC5NlvhQK5Yh')
//     .delete()
//     .then(response => console.log(response))
//     .catch(e =>{
//         console.log("Error ",e);
//     })

//SELECT
//Snapshot se corre ante todo cambio 
// db
//     .collection('usuarios')
//     .onSnapshot(snap=>{
//         const usuarios:any[]=[];
//         snap.forEach(child=>{
//             usuarios.push({
//                 id:child.id,
//                 ...child.data()
//             })
//         })
//         console.log(usuarios);
//     })

//GET
// db
// .collection('usuarios')
// .get()
// .then(snap=>{
//     const usuarios:any[]=[];
//     snap.forEach(child=>{
//         usuarios.push({
//             id:child.id,
//             ...child.data()
//         })
//     })
//     console.log(usuarios);
// })

// GET WHERE
// db
//     .collection('usuarios')
//     .where('estadoMatricula', '==', false)
//     .where('materia','==','Optativa 9 - Big Data')
//     .get()
//     .then(snap => {
//         const usuarios: any[] = [];
//         snap.forEach(child => {
//             usuarios.push({
//                 id: child.id,
//                 ...child.data()
//             })
//         })
//         console.log(usuarios);
//     })


// GET ORDER BY
db
    .collection('usuarios')
    .orderBy('numeromatricula','desc')
    .get()
    .then(snap => {
        const usuarios: any[] = [];
        snap.forEach(child => {
            usuarios.push({
                id: child.id,
                ...child.data()
            })
        })
        console.log(usuarios);
    })