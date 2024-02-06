/**
 * 
 * @param {import('./domainResponses')} domainResponses
 */

const httpStatusCode = {
  OK: 200,
  CREATED: 201,
  NOT_FOUND: 404,
};

const mapHttpStatus = (domainResponses) => httpStatusCode[domainResponses];

module.exports = mapHttpStatus;