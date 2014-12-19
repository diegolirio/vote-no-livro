<aside class="right-side" ng-init="loadVotings()">

         <!-- Content Header (Page header) -->
         <section class="content-header">
             <h1>
                 Votações
                 <small>'s</small>
                 &nbsp; <a href="#/votacao/nova" class="btn btn-success btn-sm">Criar Nova Votação</a>
             </h1>
             <ol class="breadcrumb">
                 <li><a href="${pageContext.request.contextPath}"><i class="fa fa-dashboard"></i> Home</a></li>
                 <li class="active">Votações</li>
             </ol>
         </section>

         <!-- Main content -->
         <section class="content">

              <!-- Small boxes (Stat box) -->
              <div class="row" ng-repeat="v in votings">
                  <div class="col-lg-6 col-xs-12">
                      <!-- small box -->
                      <div class="small-box bg-aqua">
                          <div class="inner">
                              <h3>
                                  <a href="#/votacao_livro/lista-de-livro/votacao/{{v.id}}"><span style="color:white;"> {{v.description}}</span></a>
                              </h3>
                              <p> 
                                  <a href="#/votacao_livro/lista-de-livro/votacao/{{v.id}}"><span style="color:white;"> {{v.id}}</span></a>
                              </p>
                          </div>
                          <div class="icon">
                              <a href="#/votacao_livro/lista-de-livro/votacao/{{v.id}}"><i style="color:white;" class="ion ion-bag"></i></a>
                          </div>
                          <a href="#/votacao_livro/lista-de-livro/votacao/{{v.id}}" class="small-box-footer">
                              mais informações <i class="fa fa-arrow-circle-right"></i>
                          </a>
                      </div>
                  </div><!-- ./col -->
		     </div>
		</section>

</aside>
