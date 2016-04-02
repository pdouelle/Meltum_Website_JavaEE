<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Boutique</title>
<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

	<link href="<c:url value="/resources/css/mycompany.css" />" rel="stylesheet">
	
    <!-- MetisMenu CSS -->
    <link href="<c:url value="/resources/bower_components/metisMenu/dist/metisMenu.min.css" />" rel="stylesheet">

    <!-- Timeline CSS -->
    <link href="<c:url value="/resources/bower_components/startbootstrap-sb-admin-2/dist/css/timeline.css" />" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="<c:url value="/resources/bower_components/startbootstrap-sb-admin-2/dist/css/sb-admin-2.css" />" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="<c:url value="/resources/bower_components/morrisjs/morris.css" />" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="<c:url value="/resources/bower_components/font-awesome/css/font-awesome.min.css" />" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
<link href="<c:url value="/resources/css/shop.css" />" rel="stylesheet">
</head>
<body>

<!-- Navigation -->
    <div class="navbar-default sidebar" role="navigation">
        <div class="sidebar-nav navbar-collapse">
            <ul class="nav" id="side-menu">
                <li class="sidebar-search">
                    <div class="input-group custom-search-form">
                        <input type="text" class="form-control" placeholder="Search...">
                        <span class="input-group-btn">
                        <button class="btn btn-default" type="button">
                            <i class="fa fa-search"></i>
                        </button>
                    </span>
                    </div>
                    <!-- /input-group -->
                </li>
               	<li>
                  	<a href="#" data-toggle="modal" data-target="#modalAddMelt"><i class="fa fa-edit fa-fw"></i> Ajouter un melt</a>
                </li>
            </ul>
        </div>
        <!-- /.sidebar-collapse -->
        </div>
        <!-- /.navbar-static-side -->
        
	<!-- Page Content -->
	<div id="page-wrapper">
		<div class="row">
			<div class="col-md-9">
				<c:forEach items="${melts}" var="melt">
					<div class="col-md-4">
						<div class="thumbnail">
							<div class="caption">
								<h4 class="pull-right">-(reduction)%</h4>
								<h4>
									<a href="#">${melt.name}</a>
								</h4>
								<p>${melt.description}</p>
							</div>
							<div class="btn-group btn-group-justified" role="group">
								<div class="btn-group" role="group">
									<button type="button" class="btn btn-default btn-xs" data-toggle="modal" data-target="#modalEditMelt${melt.id}">Modifier</button>
								</div>
								<div class="btn-group" role="group">
									<button type="button" class="btn btn-default btn-xs" data-toggle="modal" data-target="#modalRemoveMelt${melt.id}">Supprimer</button>
								</div>
							</div>
						</div>
					</div>
					<%@ include file="modalEditMelt.jsp"%>
					<%@ include file="modalRemoveMelt.jsp"%>
				</c:forEach>
			</div>
		</div>
		<%@ include file="modalAddMelt.jsp"%>
	</div>
</body>
<!-- Metis Menu Plugin JavaScript -->
<script src="<c:url value="/resources/bower_components/metisMenu/dist/metisMenu.min.js" />"></script>

<!-- Morris Charts JavaScript -->
<script src="<c:url value="/resources/bower_components/raphael/raphael-min.js" />" ></script>

<!-- Custom Theme JavaScript -->
<script src="<c:url value="/resources/bower_components/startbootstrap-sb-admin-2/dist/js/sb-admin-2.js" />"></script>
</html>
