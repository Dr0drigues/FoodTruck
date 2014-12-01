<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>Gestion des commandes</title>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/css/bootstrap/bootstrap.css"
          media="screen"/>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/css/perso/other.css"/>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/resources/js/jquery/jquery-2.1.1.min.js"></script>

</head>
<body>
<nav class="navbar navbar-twitch" role="navigation">
    <div class="navbar-inner">


        <div class="container">
            <!-- 			<div class="navbar-header"> -->
            <%-- 				<a class="navbar-brand" href="${pageContext.request.contextPath}/listerClients">Gestion de commande</a> --%>
            <!-- 			</div> -->
            <div class="navbar-header">
                <a class="navbar-brand" href="${pageContext.request.contextPath}/listerClients"> <span
                        class="small-nav">
						<!--<span class="logo">--><img
                        src="${pageContext.request.contextPath}/resources/img/banner.png"><!--</span>-->
				</span> <span class="full-nav"> Commandes </span>
                </a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="${pageContext.request.contextPath}/listerClients">
					<span class="small-nav" data-toggle="tooltip" data-placement="right" title="Clients">
							<span class="glyphicon glyphicon-user"></span>
						</span>
                            <span class="full-nav"> Clients </span>

                        </a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/listerArticles">
					<span class="small-nav" data-toggle="tooltip" data-placement="right" title="Articles">
							<span class="glyphicon glyphicon-th-list"></span>
						</span>
                            <span class="full-nav"> Articles </span>
                        </a>
                    </li>
                </ul>
            </div>
            <!--
			href="${pageContext.request.contextPath}/listerClients/add"
			/.nav-collapse -->
        </div>
    </div>
</nav>
<!-- <div class="container">
</div> -->
</body>
</html>
