
currentUser();
creatTable();
setRoles('selectRoles')



function  currentUser() {

    fetch("http://localhost:8080/admin/user/0" )
        .then(response => response.json())
        .then(user => {
            console.log("0000000")
            document.getElementById('nav').textContent = user.email + ' with roles: ' + user.role;
            let currentTableHTML = '';
            currentTableHTML = `
                            <tr>
                                <td> ${user.id}</td>
                                <td> ${user.userName}</td>
                                <td> ${user.lastName}</td>
                                <td> ${user.age}</td>
                                <td> ${user.email}</td>
                                <td> ${user.role}</td>
                            </tr>`;
            document.getElementById('current table').innerHTML = currentTableHTML;

        })
}
function buttonEdit(id){
    console.log("sadsadas"+id);
    console.log("нажата")

    fetch("http://localhost:8080/admin/user/" + id)
        .then(response => response.json())
        .then(user => {
            document.getElementById('formGroupIdInput2').value = user.id;
            document.getElementById('formGroupFirstNameInput2').value = user.userName;
            document.getElementById('formGroupLastNameInput2').value = user.lastName;
            document.getElementById('formGroupAgeInput2').value = user.age;
            document.getElementById('InputEmail2').value = user.email;
            document.getElementById('formGroupPasswordInput2').value = user.password;
           // let role = document.getElementById('editRoles');
           // // role.textContent="1111";
           // // role.value="1";
           //  let rol=document.createElement('option');
           //  rol.textContent=1111;
           //  rol.value='1';
           //  role.appendChild(rol);
           //  rol=document.createElement('option');
           // rol.textContent=2222;
           // rol.value='2';
           // role.appendChild(rol);
        });
    setRoles('editRoles');
}
function  setRoles(forma) {
    console.log('запрос ролей форма : '+forma);
    let option = document.getElementById(forma);
    option.innerHTML='';
    fetch("http://localhost:8080/admin/role/")
        .then(response => response.json())
        .then(roles => {
            roles.forEach(function (role) {
                // let option = document.getElementById(forma);
                let row = document.createElement('option');
                row.textContent = role.role.slice(5);
                row.value = role.id;
                option.appendChild(row);
            })
        });
}



function buttonDelete(id){
    console.log("нажата")
    fetch("http://localhost:8080/admin/user/" +id)
        .then(response => response.json())
        .then(user => {
            // document.getElementById('#formGroupIdInput2').value = user.id;

            let delModal = document.getElementById('formModal');
            delModal.id.value = user.id;
            delModal.username.value = user.userName;
            delModal.lastname.value = user.lastName;
            delModal.age.value = user.age;
            delModal.email.value = user.email;
            delModal.password.value = user.password;

        });
    setRoles('deleteForma');

}
function creatTable(){
    let table = document.getElementById('allUser');
    let row ='';
    fetch("http://localhost:8080/adminn/")
        .then(response => response.json())
        .then(users => {
            users.forEach(function (user){
                console.log(user);
                row+=`<tr>
                            
                            <td> ${user.id}</td>
                            <td> ${user.userName}</td>
                            <td> ${user.lastName}</td>
                            <td> ${user.age}</td>
                            <td> ${user.email}</td>
                            <td> ${user.role}</td>
                            <td><button type = "button" 
                                        id= "editUserBtn" 
                                        onclick="buttonEdit(${user.id})"                                            
                                        class="btn btn-primary" 
                                        data-bs-toggle = "modal" 
                                        data-bs-target = "#editModal"> Edit </button> </td>
                            <td><button type = "button" 
                                        id = "deleteUserBtn" 
                                        onclick="buttonDelete(${user.id})"  
                                        class="btn btn-danger" data-bs-toggle = "modal" 
                                        data-bs-target = "#deleteModal"> delete </button> </td>
                      </tr>`;



            });
            document.getElementById('users-table').innerHTML=row;

        });
    console.log('таблица');
}
