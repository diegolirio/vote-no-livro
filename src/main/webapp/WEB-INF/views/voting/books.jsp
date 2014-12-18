<div ng-init="loadBooks()" >

	<aside class="right-side" >

         <!-- Content Header (Page header) -->
         <section class="content-header">
             <h1>
                 Votação <small> {{voting.description}}</small>
             </h1>
             <ol class="breadcrumb">
                 <li><a href="${pageContext.request.contextPath}"><i class="fa fa-dashboard"></i> Home</a></li>
                 <li><a href="${pageContext.request.contextPath}"><i class="fa fa-dashboard"></i> Votações</a></li>
                 <li class="active">Votação/Livros</li>
             </ol>
         </section>

         <!-- Main content -->
         <section class="content"> 
              <div ng-repeat="b in books">
                  <div class="col-lg-2">                  	   
                      <p><img src="{{b.imgUrl}}" class="img-thumbnail img-responsive" title="{{b.title}}" /></p> <!-- width="277" height="400" -->
					  <a href="#/votacao/{{voting.id}}/livro/{{b.id}}" class="btn btn-success btn-block">
                      		<span class="text-center" title="Votar {{b.title}}">Votar <i class="fa fa-arrow-circle-right"></i></span>
                      </a>
                  </div><!-- ./col --> 
		     </div>
		</section>

	</aside>

</div>