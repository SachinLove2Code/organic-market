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
	case 'ManageProducts':
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
					return '<img src = "'+ window.contextRoot +'/resources/images/'+data+ '.jpg"  width = "200px"/>';
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
				mRender :function(data,type,row){
					if(data<1){
						return '<span style="color:red">Out Of Stock</span>';
					}else{
						return data;
					}
				}
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
	

	//----------------------------------

// Data Table for admin table
	
	var $adminProductdsTable = $('#adminProductdsTable');
	if($adminProductdsTable.length){
	var jsonUrl = window.contextRoot + '/json/data/admin/all/products';
	$adminProductdsTable.DataTable({
	
		lenghtMenu : [[10,30,50,-1],['10 Records','30 Records','50 Records','All']],
		pageLength : 30,
		ajax : {
			url :jsonUrl,
			dataSrc :'',
		},
		columns :[
			{
				data:'id'
			},
			{
				data:'code',
				bSortable:false,
				mRender:function(data,type,row){
					return '<img src = "' + window.contextRoot+'/resources/images/'+data+ '.jpg" class = "adminDataTableImg"/>';
				}
			},
			{
				data :'name'
			},
			{
				data:'brand'
			},
			{
				data :'quantity',
				mRender :function(data,type,row){
					if(data<1){
						return '<span style="color:red">Out Of Stock</span>';
					}else{
						return data;
					}
				}
			},
			{
				data:'unitPrice',
				mRender:function(data,type,row){
					return  '&#8377;' + data;
				}
			},
			{
				data :'active',
				bSortable:false,
				mRender : function(data,type,row){
					var str ='';
					str += '<label class="switch">';
					if(data){
						str += '<input type="checkbox" checked="checked" value="'+row.id+'" />';
					}else {
						str += '<input type="checkbox"  value="'+row.id+'" />';
					}
					str +=	'<div class="slider"></div> </label>';
					return str;
				}
			},
			{
				data :'id',
				bSortable : false,
				mRender : function(data,type,row){
					var str = '';
					str += '<a href="'+window.contextRoot+'/manage/'+data+'/product" class="btn btn-warning">';
					str += '<span class="glyphicon glyphicon-pencil"></span></a>';
					return str;
				}
			}
		],
		
		initComplete:function(){
			var api = this.api();
			api.$('.switch input[type="checkbox"]').on('change',function(){
				
				var checkbox = $(this);
				var checked = checkbox.prop('checked');
				var dMsg = (checked)? 'You want to activate the product ?':
									'You want to deactivate the product ?';
				var value = checkbox.prop('value');
				bootbox.confirm({
					title:"Product Activation and Deactivation",
					size:'medium',
					message:dMsg,
				    buttons: {
				        confirm: {
				            label: 'Confirm',
				            className: 'btn-success'
				        },
				        cancel: {
				            label: 'Cancel',
				            className: 'btn-danger'
				        }
				    },
				    closeButton: false,
					callback: function(confirmed) {
						if(confirmed){
							console.log(value);
							
							var activationUrl = window.contextRoot + '/manage/product/'+value+'/activation';
							$.post(activationUrl, function(data){
								bootbox.alert({
									size:'medium',
									title:'Information',
									closeButton: false,
									message: data
								});
							});
							
						}else{
							checkbox.prop('checked',!checked);
						}
					}
				});
				
			});
		}
	});
	}
	
	/// validation code for category
	
	var $categoryForm = $('#categoryForm');
	
	if($categoryForm.length){
		$categoryForm.validate({
			
			rules : {
				
				name : {
					required : true,
					minlength : 3
				},
				
				discription  : {
					required : true
				}
			},
			
			messages : {
				name : {
					required : 'Please add the category name!',
					minlength : 'Category name should not be less than 3 characters!'
				},
				
				discription : {
					required : 'Please add the description for this category!'
				}
			},
			
			errorElement :'em',
			errorPlacement: function(error,element){
				// adding css class of help-block
				error.addClass('help-block');
				// add error element after the input
				error.insertAfter(element);
			}
			
			
		});
	}
	
	//--------------------------------------------------------------
	
	
	
	
	

});
