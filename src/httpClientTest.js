var http = require('http');
var CircularJSON = require('circular-json');

var httpPost = function (data, aHost, aPort, aPath, callback) {

    var HTTP_SOCKET_TIMEOUT = 10000;
     var tid = null;
     var postData = null;
     //if (namespace) tid = (namespace.get('tid') ? namespace.get('tid') : null);
     //mLogger.debug(tid + 'httpPost() => ' + ' path: ' + aPath + ' got obj: ' + CircularJSON.stringify(data));
      
     try {
          postData = JSON.stringify(data);
          //postData.toString("utf8");
      } catch (err) {
          //mLogger.error('httpPost=>' + ' Error sringify data' + ' path: ' + aPath + JSON.stringify(err));
          //return callback(new Error('Error sringify data ' + ' path: ' + aPath + JSON.stringify(err)));
          return callback( { statusCode: 100, data: new Error('Error sringify data ' + ' path: ' + aPath + ' ,error: ' + JSON.stringify(err)) } );
     }

    var headers = {
      'Content-Type': 'application/json'
      //'Content-Length': postData.length
    };

    //logger.debug(LOG_TAG + ' Post request: ' + '\n postdata: ' + postData + '\n headers: ' + CircularJSON.stringify(headers) + '\n path: ' + aPath);

    var options = {
      host: aHost ,       // 'myServer.example.com',
      port: aPort ,       // 80,
      path: aPath,         //'/user/TheReddest',
      method: 'POST',
      headers: headers
    };

    var req = http.request(options, function (res) {
      res.setEncoding('utf-8');
      var statusCode = null;
      var resultObject = null;
      var errorObject = null;
      var responseString = '';
      if (res.statusCode) statusCode = res.statusCode;
      //mLogger.info('httpPost status: ' + statusCode + ' path: ' + aPath + ' postdata: ' + postData);
      
      if (!isStatusOk(res.statusCode)) {
              //mLogger.warn('httpPost error: ' + statusCode + ' path: ' + aPath + ' - ' + CircularJSON.stringify(res));
              errorObject = {
                  statusCode: statusCode,
                  data: res
              };
          //return callback(new Error('XHR post error' + ' path: ' + aPath + CircularJSON.stringify(res)));
          return callback(errorObject);
      } 

      res.on('data', function(chunk) {
        //logger.debug(LOG_TAG + ' REST response data :' + CircularJSON.stringify(data));
        responseString += chunk;
      });

      res.on('end', function() {
        //console.log('responsestring: ' + responseString);
        resultObject = {};
        //mLogger.debug('REST response data: ' + ' path: ' + aPath + ' response: ' + responseString);
        try {
            resultObject.data = JSON.parse(responseString);
        } catch (ex) {
          //mLogger.error('Error persing responseString: ' + ' path: ' + aPath + ' exception: ' + ex);
          resultObject.data = ex;
        }
        resultObject.statusCode = statusCode;
        return callback(null, resultObject);
      });
    });

    // req.on('socket', function (socket) {
    //     myTimeout = HTTP_SOCKET_TIMEOUT; // millis
    //     socket.setTimeout(myTimeout);  
    //     socket.on('timeout', function() {
    //         mLogger.error('httpPost timeout error: ' + HTTP_SOCKET_TIMEOUT + ' path: ' + aPath + ' data: ' + postData);
    //         //req.abort();
    //         //return callback({statusCode: 408, data: 'httpPost timeout error: ' + HTTP_SOCKET_TIMEOUT + ' path: ' + aPath + ' data: ' + postData});
    //     });
    // })
    
    req.on('error', function(ex) {
      // TODO: handle error.
      //console.log(LOG_TAG + 'Error: ' + JSON.stringify(e));
      //mLogger.error('httpPost error' + ' path: ' + aPath + ' error: ' + JSON.stringify(ex));
      // send async error via callback
      return callback(new Error('httpPost error' + ' path: ' + aPath + ' error: ' + JSON.stringify(ex)));
    });
      
    req.setTimeout(HTTP_SOCKET_TIMEOUT, function () {
        //mLogger.warn('httpPost timeout error: ' + HTTP_SOCKET_TIMEOUT + ' path: ' + aPath + ' data: ' + postData);
        //this.abort();
        //return callback({statusCode: 408, data: 'httpPost timeout error: ' + HTTP_SOCKET_TIMEOUT + ' path: ' + aPath + ' data: ' + postData});
    }); 
    //postData = replaceOuterQoutes(postData);
    //mLogger.debug('Sending httpPost: ' + 'path: ' + aPath + ' post string: ' + postData);

    req.write(postData, 'utf8');
    req.end();
    //return callback(new Error('Error httpPost ended' + ' path: ' + aPath ));
 }
    
var isStatusOk = function(aStatus) {
    return ((aStatus >= 200 && aStatus < 300) ? true : false);
}

var host = 'requestb.in';
var port = 80;
var path = '/xx6moyxx';

var data = {
	access_token: '1234567890',
	address: '1sdfdgerwtg dfgdsfgdsb',
	company_id: '222222',
	external_id: '111111',
	name: 'Just Name',
	phone: '555555',
	signature: 'c3757b2321842c232cf16a40aa3fb571c9b81d6a',
	timestamp: 1442409383039
}

httpPost(data, host, port, path, function (err, res) {
	console.log(err, res);
});
