Feature: Build News Validation Site to prevent fake news

  Scenario Outline: Verify <index> news from the website is <verdict>
    Given News Validation Site is open
    And Read the <index> news headline
    When Open google and search news headline
    And Find number of matching articles with similar headline with matching accuracy of <accuracy> %
    Then Verify the news is <verdict> using criteria: Minimum required supporting articles <minRequiredArticles>

    Examples: 
      | index | minRequiredArticles | accuracy | verdict |
      |     1 |                   2 |       10 | real    | #minimum index is 1
      |     1 |                   3 |      100 | fake    |

      
	Scenario: Verify exception when invalid index is provided for news headline
	    Given News Validation Site is open
	    And Attempt to read news at invalid index
	    Then NewsValidationInvalidNewsIndexException should be thrown
