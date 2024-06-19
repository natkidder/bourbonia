import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Response;

import awsClient3.AWSECommerceService;
import awsClient3.AWSECommerceServicePortType;
import awsClient3.ItemSearchRequest;
import awsClient3.ItemSearchResponse;
import awsClient3.ItemSearch;
import awsClient3.Items;
import awsClient3.Item;

import java.util.List;
import java.util.concurrent.ExecutionException;

class AmazonAsyncClient { 
    public static void main(String[ ] args) {
        // Usage
        if (args.length != 1) {
            System.err.println("Usage: java AmazonAsyncClient <access key>");
            return;
        }
        final String access_key = args[0];

        // Create service and get portType reference.
        AWSECommerceService service = new AWSECommerceService();
        AWSECommerceServicePortType port = service.getAWSECommerceServicePort();

        // Create request.
        ItemSearchRequest request = new ItemSearchRequest();

        // Add details to request.
        request.setSearchIndex("Books");
        request.setKeywords("quantum gravity");
        ItemSearch item_search= new ItemSearch();
        item_search.setAWSAccessKeyId(access_key);
        item_search.getRequest().add(request);

        port.itemSearchAsync(item_search, new MyHandler());

        // In this case, just sleep to give the search process time.
        // In a production application, other useful tasks could be
        // performed and the application could run indefinitely.
        try {
           Thread.sleep(400);
        }
        catch(InterruptedException e) { System.err.println(e); }
    }
    
    // The handler class implements handleResponse, which executes
    // if and when there's a response.
    static class MyHandler implements AsyncHandler<ItemSearchResponse> {
        public void handleResponse(Response<ItemSearchResponse> future) {
          try {
             ItemSearchResponse response = future.get();
             List<Items> item_list = response.getItems();
             for (Items next : item_list) 
               for (Item item : next.getItem())
                  System.out.println(item.getItemAttributes().getTitle());
          }
          catch(InterruptedException e) { System.err.println(e); }
          catch(ExecutionException e) { System.err.println(e); }
        }
    }
}
