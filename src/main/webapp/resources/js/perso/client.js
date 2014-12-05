$(document).ready(function() {


	// Gestion du bouton d'ajout
	$("#btnadd").click(function(event) {
		event.preventDefault();
		var href = $(this).attr("href");
		var table = $(this).parent().parent().parent();

		// On créé la boite de dialogue
		$("#dialog-client").dialog({
			resizable : false,
			height : 600,
			width : 400,
			modal : true,

			buttons : {
				"Add" : function() {
					var client = $("form#addclient").serialize();
					$.ajax({
						url : href,
						type : 'post',
						data : client,
						success : function(data) {
							// $("table#tableClient").fnReloadAjax();

							 $(
							 '#tableClient tbody')
							 .append(
							 "<tr><td>"
							 + document
							 .getElementById('lastName').value
							 + "</td><td>"
							 + document
							 .getElementById('firstName').value
							 + "</td><td>"
							 + document
							 .getElementById('mail').value);

						},
						error : function() {
							alert("erreur AJAX, client : " + client);
						}
					});
					$("#dialog-client").dialog("close");
				},
				Cancel : function() {
					// On ferme la boite de dialogue
					$("form#addclient")[0].reset();
					$("#dialog-client").dialog("close");
				}
			}
		})
	})
	
	// Gestion du bouton suppression
	$("#btndelete").click(function(event) {
		// return confirm("Supprimer ?");
		event.preventDefault();
		var href = $(this).attr("href");
		var ligne = $(this).parent().parent();

		// On ouvre une boite de dialogue
		$("#dialog-delete").dialog({
			resizable : false,
			height : 200,
			width : 300,
			modal : true,
			buttons : {
				"Delete" : function() {
					// On appel notre url en arrière plan
					$.ajax({
						url : href,
						type : 'post',
						success : function() {
							ligne.remove();
							$( "#dialog-delete" ).dialog( "close" );

						},
						error : function() {
							alert("erreur");
						}					
					});
				},
				Cancel : function() {
					 $( "#dialog-delete" ).dialog( "close" );
				}
			} 
		});
	});
	

	
	
});	
	
