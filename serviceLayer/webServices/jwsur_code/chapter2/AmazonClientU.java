import awsClient2.AWSECommerceService;
import awsClient2.AWSECommerceServicePortType;
import awsClient2.ItemSearchRequest;
import awsClient2.ItemSearchResponse;
import awsClient2.ItemSearch;
import awsClient2.Items;
import awsClient2.Item;
import java.util.List;

class AmazonClientU { // U is for Unwrapped style
    public static void main(String[ ] args) {
        // Usage
        if (args.length != 1) {
            System.err.println("Usage: java AmazonClientW <access key<");
            return;
        }
        final String access_key = args[0];

        // Create service and get portType reference.
        AWSECommerceService service = new AWSECommerceService();
        AWSECommerceServicePortType port = 
          service.getAWSECommerceServicePort();

        // Create request.
        ItemSearchRequest request = new ItemSearchRequest();

        // Add details to request.
        request.setSearchIndex("Books");
        request.setKeywords("quantum gravity");
        ItemSearch item_search= new ItemSearch();
        item_search.setAWSAccessKeyId(access_key);
        item_search.getRequest().add(request);

        // Invoke service operation and get response.
        ItemSearchResponse response = port.itemSearch(item_search);

        List<Items> item_list = response.getItems();
        for (Items next : item_list) 
           for (Item item : next.getItem())
              System.out.println(item.getItemAttributes().getTitle());
    }
}
