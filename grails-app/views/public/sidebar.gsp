<div class="col-md-12">
	<div class="panel panel-default">
		<div class="panel-heading">
			<h3 class="panel-title">Tags</h3>
		</div>
		<div class="panel-body">
		<g:each in="${tagList}" var="tag">
			<g:link action="index" params="["tag": tag?.text]">#${tag?.text}</g:link>
		</g:each>
		</div>
	</div>
</div>