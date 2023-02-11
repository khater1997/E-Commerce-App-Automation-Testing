@smoke
Feature:  F07_followUs | users could open followUs links

  Scenario: user opens facebook link
    When user click on facebook icon
    Then user navigate to facebook page "https://www.facebook.com/nopCommerce" and opened in new tab

  Scenario: user opens twitter link
    When user click on twitter icon
    Then user navigate to twitter page "https://twitter.com/nopCommerce" and opened in new tab

  Scenario: user opens rss link
    When user click on rss icon
    #Then user navigate to rss page"https://demo.nopcommerce.com/new-online-store-is-open" and opened in new tab

  Scenario: user opens youtube link
    When user click on youtube icon
    Then user navigate to youtube page "https://www.youtube.com/user/nopCommerce" and opened in new tab