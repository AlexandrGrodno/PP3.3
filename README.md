
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css" rel="stylesheet">
    <title>Bootstrap Example</title>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body class="p-3 m-0 border-0 bd-example m-0 border-0 bg-body-tertiary ">

<!-- Example Code -->

<nav class="navbar navbar-dark bg-dark">
    <div class="text-white">gfdsgd</div>
    <a class="text-white" href="@{/logout}">Logout</a>
</nav>
<br>
<div class="container"><!-- боковая панель-->
    <div class="row ">
        <div class="col-md-2  bg-white " style="height: 900px;">
            <ul class="nav  nav-pills flex-column  style=width: 25%">
                <li class="nav-item">
                    <a class="nav-link active" type="radio" aria-current="page" 
                     href="#" 
                     data-bs-toggle="collapse"
                      data-bs-target=".multi-collapse" 
                      aria-expanded="true"
                     aria-controls="collapseWidthExample multiCollapseExample1">Admin</a>
                </li>
                <li class="nav-item ">
                    <a class="nav-link" type="radio" data-bs-toggle="collapse" data-bs-target=".multi-collapse" aria-expanded="false" aria-controls="collapseWidthExample2" href="#">User</a>
                </li>


            </ul>
            
            <!-- Content -->
            <!-- основная -->
        </div>
        <div class="col-md-10">
          <!--навигация admin-->
          <div class="collapse show multi-collapse " id="multiCollapseExample1">
            
            <ul class="nav nav-tabs" id="myTab" role="tablist">
                <li class="nav-item" role="presentation">
                    <button class="nav-link active" id="home-tab" data-bs-toggle="tab" data-bs-target="#home" type="button" role="tab" aria-controls="home" aria-selected="true">User table</button>

                <li class="nav-item" role="presentation">
                    <button class="nav-link" id="profile-tab" data-bs-toggle="tab" data-bs-target="#profile" type="button" role="tab" aria-controls="profile" aria-selected="false">New User</button>
                </li>

            </ul><!--содержание панелей-->
            <div class="tab-content">
                <!--вкладка User Table-->
                <div class="tab-pane active" id="home" role="tabpanel" aria-labelledby="home-tab" tabindex="0">
                    <nav class="navbar navbar-light" style="background-color:#3444;">
                        user<!-- вкладка с таблицей -->
                    </nav>
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th>#</th>
                            <th>First Name</th>
                            <th>Last Name</th>
                            <th>Age</th>
                            <th>Email</th>
                            <th>Role</th>
                            <th>Edit</th>
                            <th>Delete</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <th scope="row"></th>
                            <td>Email</td>
                            <td>ritesen </td>
                            <td>Age</td>
                            <td>Email</td>
                            <td>Role</td>
                            <td>
                              <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#editModal">
                                Edit
                              </button>
                            </td>
                            <td>
                              <button type="button" class="btn btn-danger" data-bs-toggle="modal"      data-bs-target="#deleteModal">                            
                                Delete
                             </button>
                            </td>
                        </tr>                        
                        </tbody>
                    </table>
                </div>
                
                <!-- вкладка new User-->
                <div class="tab-pane" id="profile" role="tabpanel" 
                aria-labelledby="profile-tab" tabindex="0">
                    <nav class="navbar navbar-dark bg-secondary">
                        <div class="text-white">Add new User</div>
                    </nav>
                    <!-- forma ввода данных нового Usre-->
                    <div class="container text-center ">
                        <form>
                            <div class="form-group col-4 mx-auto p-2 ">
                                <label for="formGroupExampleInput">Example label</label>
                                <input type="text" class="form-control" id="formGroupExampleInput" placeholder="Example input">
                            </div>
                            <div class="form-group col-4 mx-auto p-1">
                                <label for="formGroupExampleInput2">Another label</label>
                                <input type="text" class="form-control" id="formGroupExampleInput2" placeholder="Another input">
                            </div>
                            <div class="form-group col-4 mx-auto p-1">
                                <label for="formGroupExampleInput2">Another label</label>
                                <input type="text" class="form-control" id="formGroupExampleInput2" placeholder="Another input">
                            </div>
                            <div class="mb-3 col-4 mx-auto p-1">
                                <label for="exampleInputEmail1" class="form-label">Email</label>
                                <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                                <div id="emailHelp" class="form-text">Мы никогда никому не передадим вашу электронную почту.</div>
                            </div>
                            <div class="form-group col-4 mx-auto p-1">
                                <label for="formGroupExampleInput2">Another label</label>
                                <input type="password" class="form-control" id="formGroupExampleInput2" placeholder="Another input">
                            </div>
                        </form>
                    </div>
                </div>
              </div>    
          
          </div> 
          <!--навигация user-->
          <div class="collapse multi-collapse " id="multiCollapseExample2">
            <table class="table table-striped">
              <thead>
              <tr>
                  <th>#</th>
                  <th>First Name1</th>
                  <th>Last Name1</th>
              </tr>
              </thead>
              <tbody>
              <tr>
                  <th scope="row">1</th>
                  <td>Mark</td>
                  <td>Otto</td>
              </tr>
              <tr>
                  <th scope="row">2</th>
                  <td>Jacob</td>
                  <td>Thornton</td>
              </tr>
              </tbody>
          </table>
          </div>
        </div>
        

    </div>
</div>
<!-- модальное окно-->
<div class="modal fade" id="editModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="exampleModalLabel">Edit User</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Закрыть"></button>
      </div>
      <!-- содержимое модульного  окна-->
      <div class="modal-body">
        <div class="container text-center ">
          <form>
             
              <div class="form-group col-4 mx-auto p-1 fs-5">
                  <label for="formGroupFirstNameInput">First name</label>
                  <input type="text" class="form-control" id="formGroupFirstNameInput" placeholder="First name">
              </div>
              <div class="form-group col-4 mx-auto p-1 fs-5">
                  <label for="formGroupLastNameInput">Last name</label>
                  <input type="text" class="form-control" id="formGroupLastNameInput" placeholder="Last name">
              </div>
              <div class="form-group col-4 mx-auto p-1 fs-5">
                <label for="formGroupAgeInput">Age</label>
                <input type="text" class="form-control" id="formGroupAgeInput" placeholder="Age">
            </div>
              <div class="form-group col-4 mx-auto p-1 fs-5">
                  <label for="InputEmail1" class="form-label">Email</label>
                  <input type="email" class="form-control" id="InputEmail1" aria-describedby="emailHelp">                  
              </div>
              <div class="form-group col-4 mx-auto p-1 fs-5">
                  <label for="formGroupExampleInput2">Password</label>
                  <input type="password" class="form-control" id="formGroupExampleInput2" placeholder="Another input">
              </div>
              <br>
              <select class="form-select" multiple aria-label="пример множественного выбора">
                <option selected>Откройте это меню выбора</option>
                <option value="1">Один</option>
                <option value="2">Два</option>
              </select>
          </form>
      </div>
      </div>
      <div class="modal-footer">        
        <button type="button" class="btn btn-primary">Edit</button>
      </div>
    </div>
  </div>
</div>
<!-- модальное окно 2-->
<div class="modal fade" id="deleteModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="exampleModalLabel">Заголовок модального окна</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Закрыть"></button>
      </div>
      <!-- содержимое модульного  окна-->
      <div class="modal-body">
        <div class="container text-center ">
          <form>
            <div class="form-group  col-4 mx-auto p-1 fs-5">
              <label for="formGroupIdInput">Id</label>
              <input type="text" class="form-control" value="Ввод здесь только для чтения..." aria-label="привер ввода только для чтения" readonly id="formGroupIdInput" placeholder="">
          </div>
          <div class="form-group col-4 mx-auto p-1 fs-5">
              <label for="formGroupFirstNameInput">First name</label>
              <input type="text" class="form-control"  value="Ввод здесь только для чтения..." aria-label="привер ввода только для чтения" readonly id="formGroupFirstNameInput" placeholder="First name">
          </div>
          <div class="form-group col-4 mx-auto p-1 fs-5">
              <label for="formGroupLastNameInput">Last name</label>
              <input type="text" class="form-control" value="Ввод здесь только для чтения..." aria-label="привер ввода только для чтения" readonly id="formGroupLastNameInput" placeholder="Last name">
          </div>
          <div class="form-group col-4 mx-auto p-1 fs-5">
            <label for="formGroupAgeInput">Age</label>
            <input type="text" class="form-control" value="Ввод здесь только для чтения..." aria-label="привер ввода только для чтения" readonly id="formGroupAgeInput" placeholder="Age">
        </div>
          <div class="form-group col-4 mx-auto p-1 fs-5">
              <label for="InputEmail1" class="form-label">Email</label>
              <input type="email" class="form-control" value="Ввод здесь только для чтения..." aria-label="привер ввода только для чтения" readonly id="InputEmail1" aria-describedby="emailHelp">                  
          </div>
          <div class="form-group col-4 mx-auto p-1 fs-5">
              <label for="formGroupExampleInput2">Password</label>
              <input type="password" class="form-control" value="Ввод здесь только для чтения..." aria-label="привер ввода только для чтения" readonly id="formGroupExampleInput2" placeholder="Another input">
          </div>
          <br>
          <select class="form-select" multiple aria-label="пример множественного выбора">
            <option selected>Откройте это меню выбора</option>
            <option value="1">Один</option>
            <option value="2">Два</option>
          </select>
          </form>
      </div>
      </div>
      <div class="modal-footer">        
        <button type="button" class="btn btn-primary">Сохранить изменения</button>
      </div>
    </div>
  </div>
</div>

<!-- End Example Code -->
</body>
</html>
