package objects;

import org.openqa.selenium.By;

public final class Elements 
{

	public static   int numberOfItems;

	public static   String assert1="Furniture Online: @Upto 70% Off on Wooden Furniture Online in India at Best Price - Urban Ladder";
	public static   String assert2="Bookshelf @70% Off: Buy Bookshelves Online at Low Prices - Urban Ladder";
	public static	String urbanLadderSite="https://www.urbanladder.com/";

	public static	By storage=By.cssSelector("ul.topnav.bodytext>li:nth-child(5)>span");
	public static	By bookshelves=By.linkText("Bookshelves");
	public static	By popUp=By.cssSelector("a.close-reveal-modal.hide-mobile");
	public static	By priceFilter=By.cssSelector("div.gname:nth-child(1)");
	public static	By selectRange=By.id("price_limit_16000-40316");
	public static	By storageType=By.name("filters[storage_type][]");
	public static	By storageFilter=By.cssSelector("ul.grouplist.clearfix>li:nth-child(2)>div");
	public static	By itemsList=By.cssSelector("span.name");
	public static   By itemspricesList=By.cssSelector("div.price-number>span");
	public static	By addTocart=By.cssSelector("button[data-galabel='add to cart']");
	public static	By countofitem=By.cssSelector("span.badge-count.not-empty");
}
