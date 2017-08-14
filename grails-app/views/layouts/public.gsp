<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>
        <g:layoutTitle default="Grails"/>
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>

    <asset:stylesheet src="public.css"/>

    <g:layoutHead/>
</head>
<body>
    <!-- Static navbar -->
    <nav class="navbar navbar-default navbar-static-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          </span><a class="navbar-brand" href="#">My Twitter   </a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="#">Home</a></li>
            <li><a href="#about">About</a></li>
            <li><a href="#contact">Contact</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
    <div class="container">
        <div class="row">
            <g:if test="${flash.message}">
                <g:render template="/layouts/flash_messsage"/>
            </g:if>
            <div class="col-md-8">
            <div class="row main-content">
                <div class="col-md-12">
                    <g:layoutBody/>
                </div>
            </div></div>
            <div class="col-md-4">
                <div class="row sidebar-content">
                    <g:include action="sidebar" controller="public"/>
                </div>
            </div>
        </div>

    </div> <!-- /container -->

    <asset:javascript src="application.js"/>

</body>
</html>
