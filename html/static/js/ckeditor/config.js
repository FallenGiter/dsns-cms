// http://docs.ckeditor.com/#!/api/CKEDITOR.config
CKEDITOR.editorConfig = function( config ) {
	config.language = 'zh-cn';
	config.filebrowserImageUploadUrl = $('#appCtx').attr('appRootUrl') + '/uploadCKE?type=Images';
	config.filebrowserUploadUrl = $('#appCtx').attr('appRootUrl') + '/uploadCKE?type=files';
	config.filebrowserFlashUploadUrl = $('#appCtx').attr('appRootUrl') + '/uploadCKEtype=flash';
	
	config.toolbarGroups = [
		{ name: 'clipboard',   groups: [ 'clipboard', 'undo' ] },
		{ name: 'editing',     groups: [ 'find', 'selection', 'spellchecker' ] },
		{ name: 'links' },
		{ name: 'insert' },
		{ name: 'forms' },
		{ name: 'tools' },
		{ name: 'document',	   groups: [ 'mode', 'document', 'doctools' ] },
		{ name: 'others' },
		'/',
		{ name: 'basicstyles', groups: [ 'basicstyles', 'cleanup' ] },
		{ name: 'paragraph',   groups: [ 'list', 'indent', 'blocks', 'align', 'bidi' ] },
		{ name: 'styles' },
		{ name: 'colors' }
	];
};
