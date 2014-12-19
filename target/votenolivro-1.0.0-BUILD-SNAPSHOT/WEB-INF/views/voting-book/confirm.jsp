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
	             	<h1>{{votingBook.book.title}}</h1>
	             	<p>
		             	<span ng-repeat="author in votingBook.book.authors">
		             		{{author.name}}, 
		             	</span>
		             	<span >{{votingBook.book.year}}, editora {{votingBook.book.publisher.name}}</span>
	             	</p>
				</div>           
				<br/><br/><br/> 
				<h3>Digite seu Email Para computar o Voto</h3> 
				<div class="row">  	
	             	<form ng-submit="computeVote()" class="form-horizontal" > 
	             		
						<div class="control-group">
							<div class="controls" >
								<input type="email" ng-model="user.email" class="form-control" required placeholder="Email"/>
							</div>
						</div>	             
						<br/>
						<button type="submit" class="btn btn-success">Computar Voto</button>		
	             		
		            </form>
		        </div>
		     </div>
		</section>

	</aside>

</div>