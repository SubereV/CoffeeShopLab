const CLOUDINARY_URL = "https://api.cloudinary.com/v1_1/khangvnfpt/upload";
const CLOUDINARY_UPLOAD_PRESET = "omu5ksxl";
var imgPreview = document.getElementById('img-preview');
var fileUpload = document.getElementById('file-upload');
var imgField = document.getElementById('image-url');
var indexField = document.getElementById('index');

fileUpload.addEventListener('change', function(event) {
	var file = event.target.files[0];
	var formData = new FormData();
	formData.append('file', file);
	formData.append('upload_preset', CLOUDINARY_UPLOAD_PRESET);
	axios({
		url: CLOUDINARY_URL,
		method: 'POST',
		headers: {
			"Content-Type": 'application/x-www-form-urlencoded'
		},
		data: formData
	}).then((res) => {
		console.log(">"+imgField.value);
		imgPreview.src = res.data.secure_url;
		imgField.value = res.data.secure_url;
		console.log(">>"+imgField.value);
	}).catch((err) => {
		console.log(err);
	});
})