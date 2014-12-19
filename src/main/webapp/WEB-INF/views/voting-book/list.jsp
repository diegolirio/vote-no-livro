<div ng-init="getVotingBooksByVoting()" >

	<aside class="right-side" >

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

         <section class="content"> 
              <div ng-repeat="vb in votingBooks">
                  <div class="col-lg-2">                  	   
                      <p><img src="{{vb.book.imgUrl}}" class="img-thumbnail img-responsive" title="{{vb.book.title}}" /></p>
					  <a href="#/votacao_livro/{{vb.id}}" class="btn btn-success btn-block">
                      		<span class="text-center" title="Votar {{vb.book.title}}">Votar <i class="fa fa-arrow-circle-right"></i></span>
                      </a>
                  </div>
		     </div>
		</section>

	</aside>

</div>