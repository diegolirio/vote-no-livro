<aside class="right-side" ng-init="loadBooks()">

         <!-- Content Header (Page header) -->
         <section class="content-header">
             <h1>
                 Votação <small>{{voting.descripton}}</small>
             </h1>
             <ol class="breadcrumb">
                 <li><a href="${pageContext.request.contextPath}"><i class="fa fa-dashboard"></i> Home</a></li>
                 <li><a href="${pageContext.request.contextPath}"><i class="fa fa-dashboard"></i> Votações</a></li>
                 <li class="active">Livros</li>
             </ol>
         </section>

         <!-- Main content -->
         <section class="content">

              <!-- Small boxes (Stat box) -->
              <div class="row" ng-repeat="b in books">
                  <div class="col-lg-6 col-xs-12">
                      <!-- small box -->
                      <div class="small-box bg-aqua">
                          <div class="inner">
                              <h3>
                                  <a href="#/livro/{{b.id}}"><span style="color:white;"> {{b.title}}</span></a>
                              </h3>
                              <p> 
                                  <a href="#/livro/{{b.id}}"><span style="color:white;"> {{b.id}}</span></a>
                              </p>
                          </div>
                          <div class="icon">
                              <a href="#/livro/{{b.id}}"><i style="color:white;" class="ion ion-bag"></i></a>
                          </div>
                          <a href="#/livro/{{b.id}}" class="small-box-footer">
                              mais informações <i class="fa fa-arrow-circle-right"></i>
                          </a>
                      </div>
                  </div><!-- ./col -->
		     </div>
		</section>

</aside>
