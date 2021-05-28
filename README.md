# Back-end
The backend of the application.

## Files
Has two main classes:
- `APIw/APIw.java`: Web API that gets the data from the [Public WazirX API](https://github.com/WazirX/wazirx-api) endpoints. `getJSONEndPoint()` method returns the JSON of the endpoint needed.

- `APIc/APIc.java`: Client API which processes the data from `APIw` to be easily displyed on the frontend.

Also includes `test.java` to test all the methods of the backend APIs.

`ml` includes an attempt to train and run a LSTM deep learning model to predict the prices of crypto currency.