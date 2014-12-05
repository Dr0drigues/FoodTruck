$(document).ready(function() {


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
							 
							 function callbackAsynchrone(data)
								{
								    console.log(data); // Exécuté en asynchrone
								}

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
	
	
	
	
//	// Gestion du bouton update
//	$("#btnedit").click(function(event) {
//		event.preventDefault();
//		var tableau = document.getElementById("tableClient");//on prend le tableau
//		var ligne = "tableClient".rows[0];// on prend la première ligne
//		ligne.deleteCell(0);//on supprime la première cellule de la première ligne
//		var href = $(this).attr("href");
//		var table = $(this).parent().parent().parent();
//
//		// On créé la boite de dialogue
//		$("#dialog-client").dialog({
//			resizable : false,
//			height : 600,
//			width : 400,
//			modal : true,
//
//			buttons : {
//				"Edit" : function() {
//					var client = $("form#addclient").serialize();
//					$.ajax({
//						url : href,
//						type : 'post',
//						data : client,
//						success : function(data) {
//							
//					function deplacerLigne(source, cible)
//					{
//						//on initialise nos variables
//						var ligne = document.getElementById("tableau").rows[source];//on copie la ligne
//						var nouvelle = document.getElementById("tableau").insertRow(cible);//on insère la nouvelle ligne
//						var cellules = ligne.cells;
//
//						//on boucle pour pouvoir agir sur chaque cellule
//						for(var i=0; i<cellules.length; i++)
//						{
//							nouvelle.insertCell(-1).innerHTML += cellules[i].innerHTML;//on copie chaque cellule de l'ancienne à la nouvelle ligne
//						}
//						//on supprimer l'ancienne ligne
//						document.getElementById("tableau").deleteRow(ligne.rowIndex);//on met ligne.rowIndex et non pas source car le numéro d'index a pu changer
//					}
//							 
//					},
//					error : function() {
//						alert("erreur AJAX, client : " + client);
//					}
//					});
//					$("#dialog-client").dialog("close");
//				},
//				Cancel : function() {
//					// On ferme la boite de dialogue
//					$("form#addclient")[0].reset();
//					$("#dialog-client").dialog("close");
//				}
//			}
//		})
//	})
			
	
});	
	
