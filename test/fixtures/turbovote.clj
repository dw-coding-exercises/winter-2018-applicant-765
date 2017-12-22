(ns fixtures.turbovote)

(def oregon
  (pr-str
   '({:district-divisions
      #{{:ocd-id "ocd-division/country:us/state:or",
         :voter-registration-authority-level :county,
         :election-authority-level :county,
         :voting-methods #{{:primary false,
                            :instructions {:voting-id "ID is not required to vote in Oregon."},
                            :type :in-person,
                            :excuse-required false}
                           {:primary true,
                            :type :by-mail,
                            :excuse-required false}
                           {:primary false,
                            :type :by-mail,
                            :excuse-required false,
                            :ballot-request-deadline-received #inst "2018-01-22T00:00:00.000-00:00"}},
         :voter-registration-methods #{{:instructions
                                        {:registration "You should know: you need a state-issued ID to register to vote online. If you don't have a state-issued ID,you can still register to vote by mail. (If you're submitting a change-of-name,you have to submit a paper form.)"},
                                        :type :online,
                                        :supports-iframe false,
                                        :url "https://secure.sos.state.or.us/orestar/vr/register.do?lang=eng"}
                                       {:deadline-postmarked #inst "2018-01-02T00:00:00.000-00:00",
                                        :instructions
                                        {:signature "To register in Oregon you must: \nbe a citizen of the United States \nbe a resident of Oregon \nbe at least 18 years old by election day",
                                         :idnumber "Federal law requires that you provide your driver's license number to register to vote. If you do not have a driver's license then you will have to provide at least the last four digits of your social security number. If you have neither,
 you will need to write \"NONE\" on the form. A unique identifying number will instead be assigned to you by your State."},
                                        :type :by-mail,
                                        :acceptable-forms #{{:name :nvrf}}}}
         }},
      :website "http://sos.oregon.gov/voting/Pages/myvote.aspx",
      :date #inst "2018-01-23T00:00:00.000-00:00",
      :population 4093000,
      :description "Statewide Measure 101 Special Election",
      :id #uuid "5a2aef86-5218-42b5-871e-cdf0e7d112da"})))
