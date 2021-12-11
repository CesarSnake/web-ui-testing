@UploadAndDownload
Feature: Upload and Download element of a webpage

  Scenario: Download
    Given I go to the elements webpage "upload-download"
    Then I take an elements screenshot with fileName "downloadStart"
    When I click the elements button "downloadButton"
    And I wait a "3" seconds
    Then I check it has download the file "sampleFile.jpeg"
    And I take an elements screenshot with fileName "downloadEnd"
    And I quit the elements webpage

  Scenario: Upload
    Given I go to the elements webpage "upload-download"
    Then I take an elements screenshot with fileName "uploadStart"
    When I upload a file using the upload-download input "uploadFile"
    Then I check the file has uploaded
    And I take an elements screenshot with fileName "uploadEnd"
    And I quit the elements webpage