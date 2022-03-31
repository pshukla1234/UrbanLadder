package urban_bdd;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Home;
import pages.Result;

public class UrbanStepdef 
{
	Home h1=new Home();
	Result r1=new Result();
	

    @Given("^the urbanladder website is working$")
    public void the_urbanladder_website_is_working() throws Throwable {
      
    }

    @When("^user selects bookshelves items,applies relevant filters and adds items to cart$")
    public void user_selects_bookshelves_itemsapplies_relevant_filters_and_adds_items_to_cart() throws Throwable {
        
    }

    @Then("^it validates the cart and checks if items added matches the cart$")
    public void it_validates_the_cart_and_checks_if_items_added_matches_the_cart() throws Throwable {
        
    }

	@Given("^user should be on the ulhomepage (.+)$")
	public void user_should_be_on_the_ulhomepage(String browser) throws Throwable 
	{
		h1.setUP();
		h1.Initialize(browser);
		h1.openUrl();
	}
	
	@When("^select storage and bookshelves from homepage$")
	public void select_storage_and_bookshelves_from_homepage() throws Throwable
	{
		h1.productSearch();
	}
	
	@Then("^It takes you to Bookshelves products page$")
	public void it_takes_you_to_bookshelves_products_page() throws Throwable 
	{

	}

	@Given("^user should be on bookshelves tab$")
	public void user_should_be_on_bookshelves_tab() throws Throwable 
	{

	}
	
	@When("^user should be able to apply desired filters$")
	public void user_should_be_able_to_apply_desired_filters() throws Throwable 
	{
		h1.Filters();
	}
	
	@Then("^Desired bookshelves should be visible$")
	public void desired_bookshelves_should_be_visible() throws Throwable
	{

	}

	@Given("^user should select item from desired selection$")
	public void user_should_select_item_from_desired_selection() throws Throwable 
	{
		
	}
	@When("^click on the products and add to cart in next tab$")
	public void click_on_the_products_and_add_to_cart_in_next_tab() throws Throwable 
	{
		r1.addToCart();
	}

	@Then("^user should be see the updated cart with 3 items$")
	public void user_should_be_see_the_updated_cart_with_3_items() throws Throwable 
	{

	}

	@Given("^cart value should be updated$")
	public void cart_value_should_be_updated() throws Throwable 
	{

	}

	@When("^refresh the home page$")
	public void refresh_the_home_page() throws Throwable
	{

	}

	@Then("^validate the cart item$")
	public void validate_the_cart_item() throws Throwable 
	{
		r1.selectionCriteria();
		r1.tearDown();
	}
}


