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
			height : 600,
			width : 200,
			modal : true,

			buttons : {
				"Add" : function() {
					var drink = $("form#drink").serialize();
					$.ajax({
						url : href,
						type : 'post',
						data : drink,
						success : function(data) {
							alert("datas ajoutés via AJAX, drink : " + drink);
						},
						error : function() {
							alert("erreur AJAX, drink : " + drink);
						}
					});
					$("#dialog-drink").dialog("close");
				},
				Cancel : function() {
					// On ferme la boite de dialogue
					$("form#drink").reset();
					$("#dialog-drink").dialog("close");
				}
			}
		});

	});

});