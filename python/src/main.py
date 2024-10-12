#!/usr/bin/env python
# ============ IMPORTS ================
from selenium import webdriver
from webdriver_manager.chrome import ChromeDriverManager
from selenium.webdriver.chrome.service import Service as ChromeService
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.by import By
import test
import unittest
from yaml import safe_load_all as yaml
# ============== FUNC =================
# class PythonOrgSearch(unittest.TestCase):

#     def setUp(self):
#         options = Options()
#         options.add_argument('--headless=new')
#         self.driver = webdriver.Chrome(service=ChromeService(ChromeDriverManager().install()), options=options)

#     def test_search_in_python_org(self):
#         driver = self.driver
#         driver.get("http://www.python.org")
#         self.assertIn("Python", driver.title)
#         elem = driver.find_element(By.NAME, "q")
#         elem.send_keys("pycon")
#         elem.send_keys(Keys.RETURN)
#         self.assertNotIn("No results found.", driver.page_source)


#     def tearDown(self):
#         self.driver.close()

# # ============== MAIN =================
if __name__ == "__main__":
    options = Options()
    options.add_argument('--headless=new')
    driver = webdriver.Chrome(
        '/usr/bin/chromedriver',
        options=options,
        
        )
    driver.get("http://www.python.org")
    driver.close()

