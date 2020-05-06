node ('salve1') {
    stage('Dev Push') {
		if (env.BRANCH_NAME == 'dev') {
			echo 'Runnig SE Grid Job'
			build 'selenium_grid_docker'
			echo 'Runnig Maven test'
			build 'test_code'
			echo 'Not Runnig Production Push as its dev branch commit'
		}
   }
}

node ('prod') {
    stage('Production Push') {
		if (env.BRANCH_NAME == 'master') {
			echo 'Runnig SE Grid Job'
			build 'selenium_grid_docker'
			echo 'Runnig Maven test'
			build 'test_code'
			echo 'Runnig Production Push as its master branch commit'
			build 'prod_push'
		}
   }
}

