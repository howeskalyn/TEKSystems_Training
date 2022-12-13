<jsp:include page="include/header.jsp" />

<script>
    $(document).ready(
        function () {
            $('input[type=radio]').click(function () {
                console.log("user clicked : " + this.value);

                $.ajax({
                    url: "/ajaxcall", // the mapping function in eclipse
                    data: {
                        clickedValue: this.value
                    },
                    success: function (data) {
                        console.log("server responded success with ");
                        console.log(data);
                    },
                    error: function (data) {
                        console.log("AJAX Call failed ");
                        console.log(data);
                    }
                });
            });
        }
    );
</script>

<h2 style="color: black;">Ajax Example</h2>

<div style="margin: 20px;">
    <input type="radio" id="html" name="fav_language" value="HTML">
    <label for="html">HTML</label><br>
    <input type="radio" id="css" name="fav_language" value="CSS">
    <label for="css">CSS</label><br>
    <input type="radio" id="javascript" name="fav_language" value="JavaScript">
    <label for="javascript">JavaScript</label>
</div>

<jsp:include page="include/footer.jsp" />