$(function() {

	switch (menu) {

	case 'About Us':
		$('#about').addClass('active');
		break;
	case 'Contact Us':
		$('#contact').addClass('active');
		break;
	case 'All Products':
		$('#listproduct').addClass('active');
		break;
	case 'Manage Products':
		$('#manageProducts').addClass('active');
		break;
	default:
		if (menu == "Home")
			break;
		$('#listproduct').addClass('active');
		$('#a_' + menu).addClass('active');
		break;

	}

	// jquery Data table

	var $table = $('#productListTable');
	if ($table.length) {
		// console.log('Inside the data table!');

		var jsonUrl = '';
		if (window.categoryID == '') {
			jsonUrl = window.contextRoot + '/json/data/all/products';
		} else {
			jsonUrl = window.contextRoot + '/json/data/category/'
					+ window.categoryID + '/products';
		}

		$table.DataTable({
			lengthMenu : [ [ 2, 3, 4, -1 ],
					[ '2 Records', '3 Records', '4 Records', 'All' ] ],
			pageLength : 5,
			ajax : {

				url : jsonUrl,
				/* contentType: 'application/json; charset=utf-8', */

				dataSrc : ''
			},
			columns : [
		
				
			{
				data : 'code',
				bSortable:false,
				mRender : function(data,type,row){
					return '<img src = "'+ window.contextRoot +'/resources/images/'+data+ '.jpg"  width = "200px"/>'
				}
			},
			{
				data : 'name',

			},

			{
				data : 'brand',

			}, {
				data : 'unitPrice',
				mRender : function(data, type, row) {
					return '&#8377; ' + data
				}

			}, {
				data : 'quantity',

			},{
				data : 'id',
				bSortable:false,
				mRender : function(data,type,row){
					var str ='';
					str += '<a  href ="'+window.contextRoot+ '/show/'+data+'/product" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span></a> &#160;';
					str += '<a href ="'+window.contextRoot+ '/cart/add/'+data+'/product"  class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
					return str;
				}

			},

			]
		});
	}
	
	// dismissing the alert after three seconds
	
	var $alert = $('.alert');
	
	if($alert.length){
		setTimeout(function() {
			$alert.fadeOut('slow');
		},3000)
		
	}

});
