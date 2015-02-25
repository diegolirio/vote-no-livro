<aside ng-controller="VotingMyController as votingMyCtrl" class="right-side" >

         <!-- Content Header (Page header) -->
         <section class="content-header">
         	
             <h1>
                 Minhas Vota��es
                 &nbsp; 
                 <a ng-show="userCtrl.user != null" href="#/votacao/nova" class="btn btn-success btn-sm">Criar Nova Vota��o</a>
             </h1>
             
             <ol class="breadcrumb">
                 <li><a href="${pageContext.request.contextPath}"><i class="fa fa-dashboard"></i> Home</a></li>
                 <li class="active">Vota��es</li>
             </ol>
         </section>

         <!-- Main content -->
         <section class="content">

              <!-- Small boxes (Stat box) -->
              <div class="row">
                  <div ng-repeat="v in votingMyCtrl.votings" class="col-lg-6 col-md-6">
                      <!-- small box -->
                      <div class="small-box bg-aqua">
                          <div class="inner">
                              <h3>
                                  <a href="#/votacao/editar/{{v.id}}"><span style="color:white;"> {{v.description}}</span></a>
                                  <small ng-show="userCtrl.user != null && userCtrl.user.id == v.userOwner.id"><a href="#/votacao/editar/{{v.id}}">Editar</a></small>
                              </h3>
                              <p><span>{{v.status}}</span></p>
                          </div>  
                          <div class="icon">
                              <a href="#/votacao_livro/lista-de-livro/votacao/{{v.id}}"><i style="color:white;" class="ion ion-bag"></i></a>
                          </div>
                          
                          <a href="#/votacao/editar/{{v.id}}" class="small-box-footer">
                              <!-- mais informa��es  --> <i class="fa fa-arrow-circle-right"></i>
                          </a>
                      </div>
                  </div><!-- ./col -->
		     </div>
		</section>

</aside>