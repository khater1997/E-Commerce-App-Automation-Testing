@smoke
  Feature: F08_Wishlist | user could add items to wishlist
    Scenario: user select an item to add to wishlist
      When user clicks on wishlist button on this product (HTC One M8 Android L5 Lollipop)
      Then this product is added successfully to wishlist

    Scenario: user choose an item to add to wishlist and verify quantity of that product
      When user clicks on wishlist button on this product (HTC One M8 Android L5 Lollipop)
      And clicks on wishlist link
      Then verify the product is added successfully and product quantity is more than zero