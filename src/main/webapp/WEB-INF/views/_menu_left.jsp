
            <aside class="left-side sidebar-offcanvas" ng-hide="hideMenu">
                <!-- sidebar: style can be found in sidebar.less -->
                <section class="sidebar">
	                    <!-- Sidebar user panel -->
	                    <div class="user-panel" ng-show="userCtrl.isLoggedIn"> 
	                        <div class="pull-left image">
	                            <img src="${pageContext.request.contextPath}/static/adminlte-master/img/avatar-215x215.png" class="img-circle" alt="User Image" />
	                        </div>
	                        <div class="pull-left info">
	                            <p>Olá, {{userCtrl.user.nickname}}</p>
	                            <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
	                        </div>
	                    </div> 
                    <!-- search form -->
<!--                     <form action="#" method="get" class="sidebar-form"> -->
<!--                         <div class="input-group"> -->
<!--                             <input type="text" name="q" class="form-control" placeholder="Pesquisar..."/> -->
<!--                             <span class="input-group-btn"> -->
<!--                                 <button type='submit' name='seach' id='search-btn' class="btn btn-flat"><i class="fa fa-search"></i></button> -->
<!--                             </span>  -->
<!--                         </div> -->
<!--                     </form> -->
                    <!-- /.search form -->
                    <!-- sidebar menu: : style can be found in sidebar.less -->
                    <ul class="sidebar-menu">
                        <li class="active">
                            <a href="#/votacao/s">
                                <i class="fa fa-globe"></i> <span>Votações</span> <!-- <small class="badge pull-right bg-green">novo</small> -->
                            </a>
                        </li>
                        <li ng-show="userCtrl.user != null">
                        	<a href="#/votacao/my">
                        		<i class="fa fa-star-o"></i> <span>Minhas votações</span>
                        	</a>
                        </li>                        
                        <!-- 
                        <li>
                            <a href="pages/widgets.html">
                                <i class="fa fa-table"></i> <span>Classificação</span>
                            </a>
                        </li>
                        <li>
                            <a href="pages/widgets.html">
                                <i class="fa fa-globe"></i> <span>Artilharia</span>
                            </a>
                        </li>
                        <li>
                            <a href="pages/widgets.html">
                                <i class="fa fa-star-o"></i> <span>Times</span>
                            </a>
                        </li>
                        <li>
                            <a href="pages/widgets.html">
                                <i class="fa fa-group"></i> <span>Jogadores</span>
                            </a>
                        </li>
                        <li>
                            <a href="pages/widgets.html">
                                <i class="fa fa-bar-chart-o"></i> <span>Graficos</span>
                            </a>
                        </li>
                         -->
                    </ul>
                </section>
                <!-- /.sidebar -->
            </aside>
