currentUser(2);
creatTable();
function  currentUser(id) {
    fetch("http://localhost:8080/admin/user/" + id)
        .then(response => response.json())
        .then(user => {
            console.log(user);
            console.log("0000000")
            return user;
        });


}
function creatTable(){
    fetch("http://localhost:8080/adminn/")
        .then(response => response.json())
        .then(users => {
            users.forEach(function (elem){
                console.log(elem)

            });


        });

}
