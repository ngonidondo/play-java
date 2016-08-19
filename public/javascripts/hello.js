       var allFriends
        $.get( "/allFriends", function( data ) {
            allFriends = data;
            $.each(allFriends, function() {
                var li = "<li><a data-id='" + this.email + "'>"
                    + this.fname + " " + this.lname + "</a></li>";
                $("#friendsList").append(li);
            });
        });
        $(function(){
            $("#addFriend").hide();
            $("#editFriend").hide();
            $("#friendsList").on("click", "li > a" , function(){
                var thePath = "/getFriend?friendId=" +  $(this).attr("data-id");
                var theId = $(this).attr("data-id");
                $.get( thePath, function( data ) {
                    $("#editEmail").val(data.email);
                    $("#editFname").val(data.fname);
                    $("#editLname").val(data.lname);
                    $("#editPhotoURL").val(data.photoURL);
                    $("#editFriend img").attr("src", data.photoURL);
                    $("#editFriend > form").attr("action", "/editFriend?friendId=" + theId);
                    $("#unFriend").attr("href", "/unFriend?friendId=" + theId);
                    $("#addFriend").hide();
                    $("#editFriend").show();
                });
            });
            $("#addPhotoURL").on("focusout", function(){
                $("#addFriend img").attr("src", $(this).val());
            });
            $("#addFriendBtn").on("click",function(){
                $("#addFriend").show();
                $("#editFriend").hide();
            });
        });