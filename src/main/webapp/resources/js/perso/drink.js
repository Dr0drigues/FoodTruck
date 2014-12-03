/**
 * 
 */
$(document).ready(function() {

	// Gestion du bouton suppression
	$(".delete").click(function(event) {
		// return confirm("Supprimer ?");
		event.preventDefault();
		var href = $(this).attr("href");
		var ligne = $(this).parent().parent();

		// On ouvre une boite de dialogue
		$("#dialog-confirm").dialog({
			resizable : false,
			height : 140,
			modal : true,
			buttons : [ {
				"Delete" : function() {
					// On appel notre url en arrière plan
					$.get(href, function(data) {
						// On supprime la ligne une fois la suppression faite
						// sur le serveur
						ligne.remove();
					});
					// On ferme la boite de dialogue
					$(this).dialog("close");
				},
				Cancel : function() {
					// On ferme la boite de dialogue
					$(this).dialog("close");
				}
			} ]
		});

	});

	// Gestion du bouton d'ajout
	$("#add").click(function(event) {
		event.preventDefault();
		var href = $(this).attr("href");
		var table = $(this).parent().parent().parent();

		// On créé la boite de dialogue
		$("#dialog-drink").dialog({			
			resizable : false,
			height : 680,
			modal : true,
			
			buttons : {
				"Add" : function() {
					// On appel notre url en arrière plan
					alert(href);
					$.get(href, function(data) {
						// On ajoute la ligne une fois l'ajout effectué sur le
						// serveur
						// ...						
					});
					// On ferme la boite de dialogue
					$("#dialog-drink").dialog("close");
				},
				Cancel : function() {
					// On ferme la boite de dialogue
					$("#dialog-drink").dialog("close");
				}
			} 
		});		
		

	});

});