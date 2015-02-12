<div ng-controller="VotingBookListByVoting as votingBookListByVoting" >

	<aside class="right-side" >

         <section class="content-header">
             <h1>
                 Votação <small>{{votingBookListByVoting.voting.description}}</small>
             </h1>
             <ol class="breadcrumb">
                 <li><a href="${pageContext.request.contextPath}"><i class="fa fa-dashboard"></i> Home</a></li>
                 <li><a href="${pageContext.request.contextPath}"><i class="fa fa-dashboard"></i> Votações</a></li>
                 <li class="active">Votação/Livros</li>
             </ol>
         </section>

         <section class="content">  
              <div ng-repeat="vb in votingBookListByVoting.votingBooks"> 
                  <div class="col-lg-2 col-sm-2 col-md-3 col-xs-8">                  	   
                      <p><img src="{{vb.book.imgUrl}}" class="img-thumbnail img-responsive" title="{{vb.book.title}}" /></p>
					  <a href="#/votacao_livro/{{vb.id}}" class="btn btn-success btn-block"> 
					  	<i class="glyphicon glyphicon-ok"></i>  Votar 
                      </a>
                      <br/>
                  </div>
		     </div>
		</section>

	</aside>

</div>