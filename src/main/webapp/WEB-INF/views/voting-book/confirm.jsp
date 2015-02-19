<div ng-controller="VotingBookConfirmVote as votingBookConfirmVote">

	<aside class="right-side" >

         <!-- Content Header (Page header) -->
         <section class="content-header">

             <h1>
                 <small>Votação</small> {{votingBookConfirmVote.votingBook.voting.description}} 
             </h1>             
             
             
             <ol class="breadcrumb">
                 <li><a href="${pageContext.request.contextPath}"><i class="fa fa-dashboard"></i> Home</a></li>
                 <li><a href="${pageContext.request.contextPath}"><i class="fa fa-dashboard"></i> Votações</a></li>
                 <li><a href="${pageContext.request.contextPath}"><i class="fa fa-dashboard"></i> Votação/Livros</a></li>
                 <li class="active">Votar</li> 
             </ol>
         </section>

         <!-- Main content -->
         <section class="content" ng-show="!votingBookConfirmVote.confirmedVote"> 
             <div class="col-lg-3 col-md-6 col-sm-4 col-xs-12">              
                  <img src="{{votingBookConfirmVote.votingBook.book.imgUrl}}" class="img-thumbnail img-responsive" />
             </div>
             <div class="col-lg-6 col-md-6 col-sm-8 col-xs-12">
             	<div class="row">
	               	  <a href="#/votacao_livro/lista-de-livro/votacao/{{votingBookConfirmVote.votingBook.voting.id}}" class="btn btn-danger btn-xs"> 
						  <i class="fa fa-reply"></i>  Voltar 
	                  </a>             	
	             	<h2 class="text-info">{{votingBookConfirmVote.votingBook.book.title}}</h2>
	             	<p>
		             	<span ng-repeat="author in votingBook.book.authors">
		             		{{votingBookConfirmVote.author.name}}, 
		             	</span>
		             	<span>{{votingBookConfirmVote.votingBook.book.year}}, editora {{votingBookConfirmVote.votingBook.book.publisher.name}}</span>
	             	</p>
				</div>           
				<br/><br/><br/> 
				<div class="row">  	
	             	<form ng-submit="votingBookConfirmVote.computeVote()" class="form-horizontal" > 
	             		
	             		<input type="hidden" ng-model="votingBookConfirmVote.vote.votingBook.id" value="{{votingBookConfirmVote.votingBook.id}}"/>
	             		
						<div class="control-group">
							<div class="controls" ng-hide="votingBookConfirmVote.isLoggedIn">  
								<label>Digite seu Email Para computar o Voto</label> 
								<input type="email" ng-model="votingBookConfirmVote.vote.user.email" class="form-control" required placeholder="Email" name="email"/>
							</div>
							<div class="controls" ng-show="votingBookConfirmVote.isLoggedIn">
								<h2>{{votingBookConfirmVote.user.email}}</h2>
							</div>
						</div>  
						<br/>
						<button type="submit" class="btn btn-success"><i class="glyphicon glyphicon-ok"></i> Computar Voto</button>		
	             		
		            </form>
		        </div>
		     </div>
		</section>
		
		<section class="content" ng-show="votingBookConfirmVote.confirmedVote"> 
            <a href="#/votacao_livro/lista-de-livro/votacao/{{votingBookConfirmVote.votingBook.voting.id}}" class="btn btn-danger btn-xs"> 
		  		<i class="fa fa-reply"></i>  Votar novamente 
            </a>             		
			<h1 class="text-danger">
				Seu voto foi computado! 
				<small ng-show="votingBookConfirmVote.completeRegistration"> <a href="#/usuario/cadastro/{{votingBookConfirmVote.vote.user.email}}"> Complete seu cadastro...</a></small> 
			</h1>
	        <section class="content"> 
	              <div ng-repeat="vb in votingBookConfirmVote.votingBooks">
	                  <div class="col-lg-2 col-sm-2 col-md-3 col-xs-8">                  	   
	                      <p><img src="{{vb.book.imgUrl}}" class="img-thumbnail img-responsive" title="{{vb.book.title}}" /></p>
					       <p class="text-center">
					       		{{vb.countVotes * 100 / vb.voting.countTotal | number:0 }} % 
					       		<span class="text-muted">({{vb.countVotes}})</span>
					       </p>
	                  </div>
			     </div>
			</section>		
		</section>

	</aside>

</div>

