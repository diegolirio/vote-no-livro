<div ng-init="getVotingBookById()" >

	<aside class="right-side" >

         <!-- Content Header (Page header) -->
         <section class="content-header">
             <h1>
                 Votação <small> {{votingBook.voting.description}}</small>
             </h1>
             <ol class="breadcrumb">
                 <li><a href="${pageContext.request.contextPath}"><i class="fa fa-dashboard"></i> Home</a></li>
                 <li><a href="${pageContext.request.contextPath}"><i class="fa fa-dashboard"></i> Votações</a></li>
                 <li><a href="${pageContext.request.contextPath}"><i class="fa fa-dashboard"></i> Votação/Livros</a></li>
                 <li class="active">Votar</li>
             </ol>
         </section>

         <!-- Main content -->
         <section class="content"> 
             <div class="col-lg-4">              
                  <img src="{{votingBook.book.imgUrl}}" class="img-thumbnail img-responsive" />
             </div>
             <div class="col-lg-6">
             	<div class="row">
	               	  <a href="#/votacao_livro/lista-de-livro/votacao/{{votingBook.voting.id}}" class="btn btn-danger btn-xs"> 
						  <i class="fa fa-reply"></i>  Voltar 
	                  </a>             	
	             	<h2 class="text-info">{{votingBook.book.title}}</h2>
	             	<p>
		             	<span ng-repeat="author in votingBook.book.authors">
		             		{{author.name}}, 
		             	</span>
		             	<span>{{votingBook.book.year}}, editora {{votingBook.book.publisher.name}}</span>
	             	</p>
				</div>           
				<br/><br/><br/> 
				<div class="row">  	
	             	<form ng-submit="computeVote()" class="form-horizontal" > 
	             		
						<div class="control-group">
							<div class="controls" >
								<label>Digite seu Email Para computar o Voto</label>
								<input type="email" ng-model="user.email" class="form-control" required placeholder="Email"/>
							</div>
						</div>	             
						<br/>
						<button type="submit" class="btn btn-success"><i class="glyphicon glyphicon-ok"></i> Computar Voto</button>		
	             		
		            </form>
		        </div>
		     </div>
		</section>

	</aside>

</div>