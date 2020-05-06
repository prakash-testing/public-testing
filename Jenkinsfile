pipeline {
	agent none
    	stages {
        	stage('Build') {
            		agent any
            		steps {
				script {
					if (env.BRANCH_NAME == 'master') {
						checkout scm
					} else {
						checkout scm
					}
				}
            		}
        	}
        	stage('Test') {
            		agent { 
                		label 'dev'
            		}
            		steps {
                		script {
					if (env.BRANCH_NAME == 'dev') {
						echo 'Runnig SE Grid Job'
						build 'selenium_grid_docker'
						echo 'Runnig Maven test'
						build 'test_code'
					} else {
						echo 'Runnig SE Grid Job'
						build 'selenium_grid_docker'
						echo 'Runnig Maven test'
						build 'test_code'
					}
				}
            		}
        	}
        	stage('Deploy') {
            		agent {
                		label 'prod'
            		}
            		steps {
                		script {
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
            
        	}
    	}
}
