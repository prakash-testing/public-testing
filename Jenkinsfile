node {
    stage('Build') {
		if (env.BRANCH_NAME == 'master') {
			checkout scm
			echo 'Runnig SE Grid Job'
			build 'selenium_grid_docker'
		} else {
			checkout scm
			echo 'Runnig SE Grid Job'
			build 'selenium_grid_docker'
		}
	}	
	stage('Test') {	
		if (env.BRANCH_NAME == 'master') {
			echo 'Runnig Maven test'
			build 'test_code'
		} else {
			echo 'Runnig Maven test'
			build 'test_code'
		}
   }
   stage('Deploy'){
		if (env.BRANCH_NAME == 'master') {
			echo 'Runnig Production Push as its master branch commit'
			build 'prod_push'
		}
   }
   
}

