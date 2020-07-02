$(document).ready(
    function() {

        // SUBMIT FORM
        $("#Cateform").submit(function(event) {
            // Prevent the form from submitting via the browser.
            event.preventDefault();
            ajaxPost();
            reset();
        });

        function ajaxPost() {
            // PREPARE FORM DATA
            var formData = {

                categoryId : $("#CatId").val(),
                CategoryName : $("#CatName").val(),
                Description : $("#Catdesc").val()
            }

            // DO POST
            $.ajax({
                type : "POST",
                contentType : "application/json",
                url : "http://localhost:8080/Categories",
                data : JSON.stringify(formData),
                dataType : 'json',
                success : function(result)
                {
                    if (result.status == "success")
                    {
                        $("#postResultDiv").html(
                            "" + result.data.CategoryName
                            + "Post Successfully! <br>"
                            + "---> Congrats !!" + "</p>");
                    } else {
                        $("#postResultDiv").html("<strong>Error</strong>");
                    }
                    console.log(result);
                },
                error : function(e) {
                    alert("Error!")
                    console.log("ERROR: ", e);
                }
            });

        }
        
        
      function reset() {
          $('#CatName').val("")
          $('#Catdesc').val("")
      }

    })

