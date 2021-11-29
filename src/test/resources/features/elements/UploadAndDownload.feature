Feature: Upload and Download element of a webpage
  Scenario: Download
    Given I go to Upload and Download webpage "https://demoqa.com/upload-download"
    Then I click the upload-download webpage "downloadButton" button
    And I check it has download the file "sampleFile.jpeg"
    And I close the Upload-Download webpage

  Scenario: Upload
    Given I go to Upload and Download web page "https://demoqa.com/upload-download"
    And I take a buttons page screenshot with fileName "UploadStart"
    Then I upload a file using the upload-download input "uploadFile"
    And I check the file has uploaded
    And I take a buttons page screenshot with fileName "UploadEnd"
    And I close the Upload-Download webpage
