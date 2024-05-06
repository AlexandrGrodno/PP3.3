fetch("http://localhost:8080/api/user" )
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