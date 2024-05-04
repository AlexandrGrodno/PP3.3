
currentUser();
creatTable();



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
                                        name="edit"
                                        id= "editUserBtn" 
                                                                                     
                                        class="btn btn-primary" 
                                        data-bs-toggle = "modal" 
                                        data-bs-target = "#editModal" 
                                        th:attr ="${user.id}"
                                        userid="${user.id}" > Edit </button> </td>
                            <td><button type = "button" id = "deleteUserBtn" 
                                class="btn btn-danger" data-bs-toggle = "modal" 
                                data-bs-target = "#deleteModal" 
                                th:attr = "${user.id}"
                                userid="${user.id}" > delete </button> </td>
                      </tr>`;



            });
            document.getElementById('users-table').innerHTML=row;

        });
    console.log('таблица');
}
