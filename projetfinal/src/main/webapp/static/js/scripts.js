$(function() {

	$.datepicker.regional['fr'] = {
		closeText : 'Fermer',
		prevText : '&#x3c;Préc',
		nextText : 'Suiv&#x3e;',
		currentText : 'Aujourd\'hui',
		monthNames : [ 'Janvier', 'Février', 'Mars', 'Avril', 'Mai', 'Juin','Juillet', 'Août', 'Septembre', 'Octobre', 'Novembre','Décembre' ],
		monthNamesShort : [ 'Jan', 'Fév', 'Mar', 'Avr', 'Mai', 'Jui', 'Jul','Aoû', 'Sep', 'Oct', 'Nov', 'Déc' ],
		dayNames : [ 'Dimanche', 'Lundi', 'Mardi', 'Mercredi', 'Jeudi','Vendredi', 'Samedi' ],
		dayNamesShort : [ 'Dim', 'Lun', 'Mar', 'Mer', 'Jeu', 'Ven', 'Sam' ],
		dayNamesMin : [ 'Di', 'Lu', 'Ma', 'Me', 'Je', 'Ve', 'Sa' ],
		weekHeader : 'Sm',
		dateFormat : 'dd/mm/yy',
		firstDay : 1,
		isRTL : false,
		showMonthAfterYear : false,
		yearSuffix : '',
		changeMonth : true,
		changeYear : true
	};
	
	$.datepicker.regional['en'] = {
			changeMonth : true,
			changeYear : true
		};
	
	$.datepicker.setDefaults($.datepicker.regional[$("html").attr("lang")]);
	
	$(".datepicker").datepicker();

});