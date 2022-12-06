<jsp:include page="include/header.jsp" />

<h2 style="color:black; margin: 20px">Shows Near You</h2>

<!-- Form-->
<div class="card col-md-6">
    <div class="card-body shadow">
        <form name="myForm" class="form">
            <label for="addy">Address:</label><br>
            <input required type="text" id="addy" name="addy" value="" class="form_lines"><br>

            <label for="city">City:</label><br>
            <input required type="text" id="city" name="city" value="" class="form_lines"><br>

            <label for="state">State:</label><br>
            <select required name="State" id="state" class="form_lines">
                <option>Select...</option>
                <option value="AL">Alabama</option>
                <option value="AK">Alaska</option>
                <option value="AZ">Arizona</option>
                <option value="AR">Arkansas</option>
                <option value="CA">California</option>
                <option value="CO">Colorado</option>
                <option value="CT">Connecticut</option>
                <option value="DE">Delaware</option>
                <option value="DC">District Of Columbia</option>
                <option value="FL">Florida</option>
                <option value="GA">Georgia</option>
                <option value="HI">Hawaii</option>
                <option value="ID">Idaho</option>
                <option value="IL">Illinois</option>
                <option value="IN">Indiana</option>
                <option value="IA">Iowa</option>
                <option value="KS">Kansas</option>
                <option value="KY">Kentucky</option>
                <option value="LA">Louisiana</option>
                <option value="ME">Maine</option>
                <option value="MD">Maryland</option>
                <option value="MA">Massachusetts</option>
                <option value="MI">Michigan</option>
                <option value="MN">Minnesota</option>
                <option value="MS">Mississippi</option>
                <option value="MO">Missouri</option>
                <option value="MT">Montana</option>
                <option value="NE">Nebraska</option>
                <option value="NV">Nevada</option>
                <option value="NH">New Hampshire</option>
                <option value="NJ">New Jersey</option>
                <option value="NM">New Mexico</option>
                <option value="NY">New York</option>
                <option value="NC">North Carolina</option>
                <option value="ND">North Dakota</option>
                <option value="OH">Ohio</option>
                <option value="OK">Oklahoma</option>
                <option value="OR">Oregon</option>
                <option value="PA">Pennsylvania</option>
                <option value="RI">Rhode Island</option>
                <option value="SC">South Carolina</option>
                <option value="SD">South Dakota</option>
                <option value="TN">Tennessee</option>
                <option value="TX">Texas</option>
                <option value="UT">Utah</option>
                <option value="VT">Vermont</option>
                <option value="VA">Virginia</option>
                <option value="WA">Washington</option>
                <option value="WV">West Virginia</option>
                <option value="WI">Wisconsin</option>
                <option value="WY">Wyoming</option>
            </select><br>

            <label for="zip">Zip Code:</label><br>
            <input required type="text" id="zip" name="zip" value="" class="form_lines" pattern="[0-9]{5}"><br>

            <input type="submit" value="Submit" style="margin-top: 20px;">
        </form>
    </div>
</div>

<!-- Using external js -->
<h2 style="color: black; margin: 20px;">Results</h2>

<input type="submit" value="Display All Shows" onclick="toggle()" style="margin: 20px;">
<div id="toggle_shows" style="display: none">
    <table>
        <tr style="border: solid">
            <th style="border: solid">Artist(s)</th>
            <th style="border: solid">Venue</th>
            <th style="border: solid">City, State</th>
            <th style="border: solid">Date</th>
            <th style="border: solid">Price</th>
        </tr>
        <tr>
            <td>Harry Styles</td>
            <td>Madison Square Garden</td>
            <td>NYC, NY</td>
            <td>Jan 1, 2023 - 8:00pm</td>
            <td>$300</td>
        </tr>
        <tr>
            <td>Greta Van Fleet</td>
            <td>Capital One Arena</td>
            <td>DC, DC</td>
            <td>Feb 23, 2023 - 9:00pm</td>
            <td>$250</td>
        </tr>
    </table>
</div>